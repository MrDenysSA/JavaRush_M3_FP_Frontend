let progressBar = 0
let width = 0;
let totalQuestions = 12;
let currentQuestionProgress = 0


fetch('https://api64.ipify.org?format=json')
    .then(response => response.json())
    .then(data=>{
        document.getElementById('ipOutput').innerText= data.ip;
        initNickname()
        initGameCounter()
    })

function moveProgressBar(){
    progressBar = document.getElementById('progressBar');

    if(currentQuestionProgress < totalQuestions) {
        width += 100 / totalQuestions;
        progressBar.style.width = width + "%";
        currentQuestionProgress++;

        if(currentQuestionProgress === totalQuestions) {
            document.getElementById('progressBar').classList.add('completed');
        }
    }
}

// function next(){
//     let count = document.getElementById('counter').innerText
//     console.log(count)
//     document.getElementById('q1').value = count
// }