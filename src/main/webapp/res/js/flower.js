jQuery(function($){

    (function main(){
        onStartSurveyClick('#btn-start-survey', '#intro', '#question', 'questions');
        onNextQuestionClick('#btn-next-question');
        onNoAnswerClick('#btn-no-answer');
    })();


    var currentQuestionIndex = 0,
        answerId = 0,
        questions = [],
        answers = [],
        questionTitleContainer = '#question-title',
        questionBodyContainer = '#question-body',
        btnNext = '#btn-next-question';

    function onStartSurveyClick(button, intro, question, ajaxUrl){
        $(button).click(function(){

            $(intro).hide();
            $(question).show();

            $.get(ajaxUrl, function(result){
                if(result && result.questions && result.status === 'success'){
                    questions = result.questions;
                    showNextQuestion();
                }
            });

        });
    }

    function onNoAnswerClick(button){
        $(button).click(function(){
            submitOrShow();
        });
    }

    function onNextQuestionClick(button){
        $(button).click(function(){

            var previousQuestion = questions[currentQuestionIndex-1].id;

            if(previousQuestion){

                if($(questionBodyContainer).find('input:checked').val()){
                    answers.push({
                        featureType : previousQuestion,
                        answer : $(questionBodyContainer).find('input:checked').val()
                    });
                }

            }

            submitOrShow();

        });
    }

    function submitOrShow(){
        if($(questionBodyContainer).find('input:checked').val()){
            $('#alert-msg').hide();

            if(questions.length !== currentQuestionIndex){
                showNextQuestion();
            }
            else {
                $.ajax({
                    url: "answers",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(answers), //Stringified Json Object
                    success: function (responseJsonObject) {
                        showResults(responseJsonObject.questions);
                    }});
            }

        }
        else {
            $('#alert-msg').show();
        }
    }

    function showResults(result){

        $(questionTitleContainer).text('Best choices for you:');
        $(questionBodyContainer).empty();


        result.map(function(item){

            console.log(item.car);

            $(questionBodyContainer).append(
                $('<h3>', { text: item.car.model }),
                $('<div>', { class: 'row'}).append(
                    $('<div>', { class: 'col-md-4'}).append(
                        $('<a>', { class: 'thumbnail'}).append(
                            $('<img>', { src: item.car.photo })
                        )
                    ),
                    $('<div>', { class: 'col-md-4'}).append(
                        $('<p>', { text: 'In plus'})
                    ),
                    $('<div>', { class: 'col-md-4'}).append(
                        $('<p>', { text: 'In minus'})
                    )
                ),
                $('<div>', { class: 'progress' }).append(
                    $('<div>', { class: 'progress-bar', role: 'progressbar'}).animate({width: item.rank * 100 + '%'}).append(
                        $('<span>', { text: item.rank * 100 + '%'})
                    )
                )
            );

        });
    }

    function showNextQuestion(){
        var currentQuestion = questions[currentQuestionIndex];

        if(questions.length - 1 === currentQuestionIndex) {
            $(btnNext).find('a').text('Finish');
        }

        $(questionTitleContainer).text(currentQuestion.question);

        if(currentQuestion.type){

            var questionBody = $(questionBodyContainer).empty();

            currentQuestion.answers.map(function(answer){
               questionBody.append(
                   $('<input>', { id: 'answer' + answerId, type: 'radio', name : 'question', value : answer}),
                   $('<label>', { text: answer, for: 'answer' + answerId++ }),
                   $('<br>')
               );
            });

        }

        currentQuestionIndex++;
    }

});