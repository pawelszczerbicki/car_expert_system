jQuery(function ($) {

    (function main() {
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
        btnNext = '#btn-next-question',
        totalProgress = '#total-progress';

    function onStartSurveyClick(button, intro, question, ajaxUrl) {
        $(button).click(function () {

            $(intro).hide();
            $(question).show();

            $.get(ajaxUrl, function (result) {
                if (result && result.questions && result.status === 'success') {
                    questions = result.questions;
                    showNextQuestion();
                }
            });

        });
    }

    function onNoAnswerClick(button) {
        $(button).click(function () {
            submitOrShow('no-answer');
        });
    }

    function onNextQuestionClick(button) {
        $(button).click(function () {

            var previousQuestion = questions[currentQuestionIndex - 1].id;

            if (previousQuestion) {

                if ($(questionBodyContainer).find('input:checked').val()) {
                    answers.push({
                        featureType: previousQuestion,
                        answer: $(questionBodyContainer).find('input:checked').val()
                    });
                }

            }

            submitOrShow();

        });
    }

    function submitOrShow(action) {
        if ($(questionBodyContainer).find('input:checked').val()) {
            $('#alert-msg').hide();

            if (questions.length !== currentQuestionIndex) {
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
        else if (action === 'no-answer') {
            $('#alert-msg').hide();
            showNextQuestion();
        }
        else {
            $('#alert-msg').show();
        }
    }

    function showResults(result) {

        $(questionTitleContainer).text('Top 10 for you:');
        $(questionBodyContainer).empty();
        $(totalProgress).empty();


        result.map(function (item) {

            console.log(item.car);

            $(questionBodyContainer).append(
                $('<h3>', { text: item.car.make + ' ' + item.car.model }),
                $('<div>', { class: 'row'}).append(
                    $('<div>', { class: 'col-md-4'}).append(
                        $('<a>', { class: 'thumbnail'}).append(
                            $('<img>', { src: item.car.photo })
                        )
                    ),
                    $('<div>', { id: item.car.make.replace(' ', '') + '_' + item.car.model.replace(' ', '') + '_plus', class: 'col-md-4'}).append(
                        '<p><b><u>In plus</u></b></p>'
                    ),
                    $('<div>', { id: item.car.make.replace(' ', '') + '_' + item.car.model.replace(' ', '') + '_minus', class: 'col-md-4'}).append(
                        '<p><b><u>In minus</u></b></p>'
                    )
                ),
                $('<div>', { class: 'progress' }).append(
                    $('<div>', { class: 'progress-bar', role: 'progressbar'}).animate({width: item.rank + '%'}).append(
                        $('<span>', { text: item.rank + '%'})
                    )
                )
            );

            item.pluses.map(function(plus){
               $('#' + item.car.make.replace(' ', '') + '_' + item.car.model.replace(' ', '') + '_plus').append(
                   $('<p>', { text: plus })
               )
            });

            item.minuses.map(function(minus){
                $('#' + item.car.make.replace(' ', '') + '_' + item.car.model.replace(' ', '') + '_minus').append(
                    $('<p>', { text: minus })
                )
            });

            $(totalProgress).hide();

        });
    }

    function showNextQuestion() {
        var currentQuestion = questions[currentQuestionIndex];

        if (questions.length - 1 === currentQuestionIndex) {
            $(btnNext).find('a').text('Finish');
        }

        $(questionTitleContainer).text(currentQuestion.question);

        if (currentQuestion.type) {

            var questionBody = $(questionBodyContainer).empty();

            currentQuestion.answers.map(function (answer) {
                questionBody.append(
                    $('<input>', { id: 'answer' + answerId, type: 'radio', name: 'question', value: answer}),
                    $('<label>', { text: answer, for: 'answer' + answerId++ }),
                    $('<br>')
                );
            });

        }


        currentQuestionIndex++;

        $(totalProgress).find('.progress-bar').width(parseInt(currentQuestionIndex / questions.length * 100) + '%');
        $(totalProgress).find('.progress-bar span').text(currentQuestionIndex + '/' + questions.length);
    }

});