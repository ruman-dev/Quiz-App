package com.rumanweb.quizapp

class ModelQuestion(ques: String, opt1: String, opt2: String, opt3: String, opt4: String, ans: String, selectedAns: String = "") {

    var mQues: String = ques
    var mopt1: String = opt1
    var mopt2: String = opt2
    var mopt3: String = opt3
    var mopt4: String = opt4
    var mAns: String = ans
    var mUserSelectedAns: String = selectedAns

}