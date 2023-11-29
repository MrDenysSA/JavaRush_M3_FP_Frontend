let progressBar = 0
let width = 0;
let totalQuestions = 3;
let currentQuestionProgress = 0

let counterGame = 0

initCounterGame()
moveProgressBar()

function initCounterGame() {
    counterGame = document.getElementById('counterQuestion').innerText
}

fetch('https://api64.ipify.org?format=json')
    .then(response => response.json())
    .then(data => {
        document.getElementById('ipOutput').innerText = data.ip;
    })


function moveProgressBar() {
    progressBar = document.getElementById('progressBar')
    let count = 0;
    while (count < counterGame) {
        count++
        if (counterGame <= totalQuestions) {
            width += 100 / totalQuestions;
            progressBar.style.width = width + "%";
            // currentQuestionProgress++;

            if (currentQuestionProgress === totalQuestions) {
                document.getElementById('progressBar').classList.add('completed');
            }
        }
    }
}

