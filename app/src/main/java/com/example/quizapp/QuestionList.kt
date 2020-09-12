package com.example.quizapp

object QuestionList {
    fun getQuestions():ArrayList<Question>{
        val questionsList = arrayListOf<Question>()
        questionsList.add(Question(
            1,
            "Which crop is sown on the largest area in India?",
            "Rice",
            "Wheat",
            "Sugarcane",
            "Maize",
            1
        ))
        questionsList.add(Question(
            2,
            "Entomology is the science that studies?",
            "Behaviour of human beings",
            "Insects",
            "The origin and history of technical and scientific terms",
            "The formation of rocks",
            2
        ))
        questionsList.add(Question(
            3,
            "Galileo was an astronomer who?",
            "developed the telescope",
            "discovered four satellites of Jupiter",
            "discovered that the movement of pendulum produces a regular time measurement",
            "All the above.",
            1
        ))
        questionsList.add(Question(
            4,
            "Corey Anderson who has hit the fastest ODI century in 36 balls is from?",
            "England",
            "Australia",
            "West Indies",
            "New Zealand",
            4
        ))
        questionsList.add(Question(
            5,
            "\n" +
                    "Which of the following memory is non-volatile?",
            "SRAM",
            "DRAM",
            "ROM",
            "All of the above",
            3
        ))
        return questionsList
    }
}