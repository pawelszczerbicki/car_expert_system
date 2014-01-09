jQuery(function($){

    (function main(){
        onStartSurveyClick('#btn-start-survey', '#intro', '#question', 'questions');
        onNextQuestionClick('#btn-next-question');
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
                    console.log(questions)

                }
            });

        });
    }

    function onNextQuestionClick(button){
        $(button).click(function(){

            var previousQuestion = questions[currentQuestionIndex-1].id;

            if(previousQuestion){
                answers.push({
                    featureType : previousQuestion,
                    answer : $(questionBodyContainer).find('input:checked').val()
                });
            }


            if(questions.length !== currentQuestionIndex){
                showNextQuestion();
            }
            else {
                $.post('answers', JSON.stringify(answers), function(result){
                    console.log(result);
                });
            }
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