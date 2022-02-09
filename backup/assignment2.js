
//VARIABLE DECLARATION
let canvas = document.getElementById("myCanvas"); //store reference to canvas element
let ctx = canvas.getContext("2d"); ////store the 2d rendering context - tool used to paint in canvas
let ballRadius = 10;

let x,y;

//create random int 
function getRandomInt() {
    m = Math.random() * 2 + 2; //between 2 and 4 
    const d = new Date();
    if (d.getTime() % 2  == 0) { //determine direction based on even/odd millisecond
        m = -1 * m;
    }
    return m;
}

function resetGame() {
    //reset ball to center
    x = canvas.width/2;
    y = canvas.height/2;
}

resetGame(); //start in center 
//random direction and speed
let dx = getRandomInt();
let dy = getRandomInt(); 
//field variables
let fieldX = 5;
let fieldY = 20;
let fieldWidth = canvas.width - (fieldX*2);
let fieldHeight = canvas.height - (fieldY*2);
let midlineX = fieldX + fieldWidth/2;
//goal variables
let goalPadding = 5;
let goalWidth = 10;
let goalHeight = 150;
let goalYLeft = fieldHeight/2 - goalHeight/2 + 2*fieldX;
let goalXLeft = 0;
let goalYRight = fieldHeight/2 - goalHeight/2 + 2*fieldX;
let goalXRight = fieldWidth ;
let paddleHeight = 40;
let paddleWidth = 10;
//paddle left variables
let paddleXLeft = fieldX + goalPadding;
let paddleYLeft = fieldHeight/2 - paddleHeight/2 + 2*fieldX; 
let paddleLeftMove = 2;
//paddle right variables
let paddleXRight = canvas.width - fieldX - paddleWidth - goalPadding;
let paddleYRight = fieldHeight/2 - paddleHeight/2 + 2*fieldX; 
//paddle control variables
let upPressed = false;
let downPressed = false;
//score variables
let scoreLeft = 0;
let scoreRight = 0;
let scoreBoardWidth = 200;
let scoreBoardHeight = fieldY;
//midline variables

//arrow key listeners for right goalie
document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);

//stuck button and listener 
const button = document.querySelector('#stuck');
button.addEventListener('click', stuckButton);

//level buttons and listeners
const button2 = document.querySelector('#down');
button2.addEventListener('click', downButton);
const button3 = document.querySelector('#up');
button3.addEventListener('click', upButton);

function keyDownHandler(e) {
    if(e.key == "Up" || e.key == "ArrowUp"){
        upPressed = true;
    }
    else if(e.key == "Down" || e.key == "ArrowDown"){
        downPressed = true;
    }
}
function keyUpHandler(e) {
    if(e.key == "Up" || e.key == "ArrowUp") {
        upPressed = false;
    }
    else if(e.key == "Down" || e.key == "ArrowDown") {
        downPressed = false;
    }
}

function stuckButton () {
    alert("Setting Back to start since the ball is stuck")
    resetGame(); //recenter, score stays the same
    dx = getRandomInt();
    dy = getRandomInt();
}

//make left goalie slower
function downButton () {
    if (paddleLeftMove == 1)
        alert("You are at the lowest level");
    else{
        alert("Level Down")
        paddleLeftMove--;
    }
}

//make left goalie faster
function upButton () {
    if (paddleLeftMove == 4)
        alert("You are at the highest level");
    else{
        alert("Level Up")
        paddleLeftMove++;
    }
}

function collisionDetection() {
    //right goal
    if (x + dx > (fieldWidth+fieldX)-ballRadius) {
        if ( (y > goalYRight) && (y < (goalYRight + goalHeight)) ) {
            alert("Opponent Scored");
            scoreLeft++;
            dx = -2;
            while ( dx < 0 ) {
                dx = getRandomInt(); 
            }
            dy = getRandomInt();
            resetGame(); //ball back to center
        }
        else 
            dx = -dx;
    }
    //left goal
    if (x + dx < fieldX+ballRadius) {
        if ( (y > goalYLeft) && (y < (goalYLeft + goalHeight)) ) {
            alert("You Scored");
            scoreRight++;
            dx = 2;
            while ( dx > 0 ) {
                dx = getRandomInt(); 
            }
            dy = getRandomInt();
            resetGame();
        }
        else 
            dx = -dx;
    }
    if ( (y + dy < fieldY + ballRadius) || (y + dy > fieldY+fieldHeight - ballRadius) ) {
        dy = -dy;
    }
    //right goalie
    if (x + dx > (fieldWidth+fieldX)- ballRadius - goalWidth) {
        if ( (y > paddleYRight) && (y < (paddleYRight + paddleHeight)) ) {
            dx=-dx;
        }
    }
    //left goalie 
    if (x + dx < fieldX + ballRadius + goalWidth) {
        if ( (y > paddleYLeft) && (y < (paddleYLeft + paddleHeight)) ) {
            dx = -dx;
        }
    }
}

function leftDefend() {
    if (x < midlineX) {
        if (y < paddleYLeft) { 
            paddleYLeft-=paddleLeftMove;
            if (paddleYLeft < goalYLeft ){ //stop at upper bound of goal
                paddleYLeft = goalYLeft;
            } 
        }
        else {
            paddleYLeft+=paddleLeftMove;
            if (paddleYLeft + paddleHeight > goalYLeft + goalHeight){ //stop at lower bound of goal
                paddleYLeft = goalYLeft + goalHeight - paddleHeight;
            }
        }
        
    }
}

function rightGoalieControls() {
    if(upPressed) {
        paddleYRight -= 2;
        if (paddleYRight < goalYRight ){ //stop at upper bound of goal
            paddleYRight = goalYRight
        }
    }
    else if(downPressed) {
        paddleYRight += 2;
        if (paddleYRight + paddleHeight > goalYRight + goalHeight){ //stop at lower bound of goal
            paddleYRight = goalYRight + goalHeight - paddleHeight
        }
    }
}
function drawScoreBoard() {
    ctx.beginPath();
    ctx.rect(canvas.width/2-scoreBoardWidth/2,0,scoreBoardWidth,scoreBoardHeight);
    ctx.fillStyle = "#000000";
    ctx.strokeStyle = "#000000";    
    ctx.stroke(); // add border
    ctx.fill();
    ctx.fillStyle = "#FFFFFF";
    ctx.font = "15px Comic Sans MS";
    let scoreBoard = "  ScoreBoard  ";
    let joinedText = `${scoreLeft}${scoreBoard}${scoreRight}`
    ctx.fillText(joinedText, 180, 15);
    ctx.closePath(); 
}
function drawLeftGoal() {
    ctx.beginPath();
    ctx.rect(goalXLeft, goalYLeft, goalWidth, goalHeight);
    ctx.fillStyle = "#000000";
    ctx.strokeStyle = "#000000";    
    ctx.stroke(); // add border
    ctx.fill();
    ctx.closePath();
}
function drawRightGoal() {
    ctx.beginPath();
    ctx.rect(goalXRight, goalYRight, goalWidth, goalHeight);
    ctx.fillStyle = "#000000";
    ctx.strokeStyle = "#000000";    
    ctx.stroke(); // add border
    ctx.fill();
    ctx.closePath();
}
function drawMidLine() {
    ctx.beginPath();
    ctx.moveTo(midlineX,fieldY); //starting point
    ctx.lineTo(midlineX,fieldHeight + fieldY); //finish point
    ctx.strokeStyle = "#FFFFFF";
    ctx.stroke();
    ctx.closePath(); 
}
function drawField() {
    ctx.beginPath();
    ctx.rect(fieldX, fieldY, fieldWidth, fieldHeight);
    ctx.fillStyle = "#D0D0D0";
    ctx.strokeStyle = "#000000";
    ctx.stroke(); // add border
    ctx.fill();
    ctx.closePath();
}
function drawBall() {
    ctx.beginPath();
    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}
function drawLeftPaddle() {
    ctx.beginPath();
    ctx.rect(paddleXLeft, paddleYLeft, paddleWidth, paddleHeight);
    ctx.fillStyle = "#D0D";
    ctx.fill();
    ctx.closePath();
}
function drawRightPaddle() {
    ctx.beginPath();
    ctx.rect(paddleXRight, paddleYRight, paddleWidth, paddleHeight);
    ctx.fillStyle = "#D0D";
    ctx.fill();
    ctx.closePath();
}

function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    drawField();
    drawMidLine();
    drawLeftGoal();
    drawRightGoal();
    drawBall();
    drawLeftPaddle();
    drawRightPaddle();
    drawScoreBoard();
   
    collisionDetection();
    leftDefend();
    rightGoalieControls();
    
    
    x += dx;
    y += dy;

    requestAnimationFrame(draw); // function recalls itself infinitely
    //helps the browser render the game better than the fixed framerate we currently have implemented
    //draw() being executed again and again within a requestAnimationFrame loop 
    //control of framerate is given to browser instead of setting interval for smoother, more efficient loop
}
draw();