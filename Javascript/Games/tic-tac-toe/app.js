
/*
  Constructor for the app
*/
function TicTacToe(height,width){

  this.height = height;
  this.width  = width;
  const mainPanel = document.getElementById("mainPanel");

  /*
  *   ************* Public funtions go here ***************
  */

  this.start = function(){
    initMainPanel();
    // Attach it to window object - so that its available at all events
    Window.game = new Game(height,width);

    mainPanel.addEventListener("click",function(event){
      act(event);
    });
  }

  /*
  *   ************* Private funtions go here ***************
  */
  function initMainPanel(){
    mainPanel.setAttribute("height",height);
    mainPanel.setAttribute("width",width);

    mainPanel.appendChild(new SvgBox(0,0,20,20,height,width));

    var lineOffset = 10;
    mainPanel.appendChild(new SvgLine(lineOffset,height / 3,width - lineOffset,height / 3));
    mainPanel.appendChild(new SvgLine(lineOffset,(height * 2) / 3,width - lineOffset, (height * 2 ) / 3));
    mainPanel.appendChild(new SvgLine(width / 3,lineOffset,width / 3,height - lineOffset));
    mainPanel.appendChild(new SvgLine((width * 2)/ 3,lineOffset,(width * 2 )/ 3,height - lineOffset));
  }


  function act(event){
    console.log("X: " + event.offsetX + " Y: " + event.offsetY);
    var game = Window.game;

    if(game.isYourTurn()){

      var qaudrant = new Quadrant(event.offsetX,event.offsetY,height,width);
      game.yourturn(qaudrant);
      mainPanel.appendChild(qaudrant.circle());
      if(gameOver(game,true)){
        return;
      }

      var nextPick = game.pickTurn();
      game.myturn(nextPick);

      var cross = nextPick.cross();
      if( cross instanceof SvgCross){
        mainPanel.appendChild(cross.l1);
        mainPanel.appendChild(cross.l2);
      }

      console.log("my move",game);
      if(gameOver(game,false)){
        return;
      }

    }else{
      console.log("Not your turn !")
    }
  }

  function gameOver(game,yourTurn){

    var message = document.getElementById("message");
    if(game.gameOver){
      if(game.winner){

         if(yourTurn){
           message.classList.add("win");
           message.innerHTML = "Congratulations! You won <a href='javascript:location.reload()'> Click here </a> to play again";
         }else{
           message.classList.add("lost");
           message.innerHTML = "You lost! <a href='javascript:location.reload()'> Click here </a> to play again";
         }

      }else{
        message.classList.add("draw");
        message.innerHTML = "Match is draw ! <a href='javascript:location.reload()'> Click here </a> to play again";
      }
      return true;;
    }else{
      false;
    }
  }

}

/*
  Constructor for SVG box
*/

function SvgBox(x,y,rx,ry,h,w){
  var rect = document.createElementNS("http://www.w3.org/2000/svg","rect");

  rect.setAttribute("x",x);
  rect.setAttribute("y",y);
  rect.setAttribute("rx",rx);
  rect.setAttribute("ry",ry);
  rect.setAttribute("height",h);
  rect.setAttribute("width",w);

  return rect;
}

/*
  Constructor for SVG line
*/
function SvgLine(x1,y1,x2,y2){
  var line = document.createElementNS("http://www.w3.org/2000/svg","line");

  line.setAttribute("x1",x1);
  line.setAttribute("y1",y1);
  line.setAttribute("x2",x2);
  line.setAttribute("y2",y2);
  return line;
}

/*
  Constructor for SVG cross
*/
function SvgCross(x,y,l){
  this.l1 = new SvgLine(x-l,y-l,x+l,y+l);
  this.l2 = new SvgLine(x-l,y+l,x+l,y-l);
}

/*
  Constructor for SVG circle
*/
function SvgCircle(cx,cy,r){
  var circle = document.createElementNS("http://www.w3.org/2000/svg","circle");

  circle.setAttribute("cx",cx);
  circle.setAttribute("cy",cy);
  circle.setAttribute("r",r);
  return circle;
}


/*
*  Constructor for quadrant
*/
function Quadrant(x,y,h,w){

    // quadrant number 1,2,3 ..9
    var n = 0;

    // x and y are quadrant center points
    if( x < w / 3 ){
      this.x = w / 6;
      n = 1;
    } else if( ( x >= w / 3 ) & ( x < ( w * 2 ) / 3 ) ){
      this.x = ( w / 3 ) + ( w / 6 );
      n = 2;
    } else{
      this.x = ( ( 2 * w ) / 3 ) + ( w / 6 );
      n = 3;
    }

    if( y < h / 3 ){
      this.y = h / 6;
    } else if( ( y >= h / 3 ) & ( y < ( h * 2 ) / 3 ) ){
      this.y = ( h / 3 ) + ( h / 6 );
      n = n + 3;
    } else{
      this.y = ( ( 2 * h ) / 3 ) + ( h / 6 );
      n = n + 6;
    }

    this.n = n;


    this.circle = function(){
      var radius = ( w < h ) ? w / 12 : h/12;
      return new SvgCircle(this.x,this.y,radius);
    }

    this.cross = function(){
      var length = ( w < h ) ? w / 12 : h/12;
      return new SvgCross(this.x,this.y,length);
    }


 }

function Game(h,w){

  var myQuadrants = [];
  var yourQuadrants = [];

  var availableQuadrants = [1,2,3,4,5,6,7,8,9];
  var isYourTurn = true;

  this.winner =  false;
  this.gameOver = false;

  var winningQuadrants = [];

  this.yourturn = function(quadrant){
    console.log("Logging This in yourturn ", this);
    yourQuadrants.push(quadrant);
    quadrantTaken(quadrant.n);
    isGameOver(this);
    isYourTurn = false;

  }

  this.myturn = function(quadrant){
    myQuadrants.push(quadrant);
    quadrantTaken(quadrant.n);
    isGameOver(this);
    isYourTurn = true;
  }

  this.pickTurn = function(){
    // pick a quadrant randomly
    var pickedQuadrant = availableQuadrants[Math.floor(Math.random() * Math.floor(availableQuadrants.length))];
    console.log("Picked qudrant : " + pickedQuadrant);
    pickedQuadrant--;
    var x = ((( pickedQuadrant % 3 ) + 1) * ( w - 7))/3
    var y = ( ( Math.floor( pickedQuadrant / 3) + 1 ) * ( h - 7) ) / 3
    return new Quadrant(x,y,h,w);
  }

  this.isYourTurn = function(){
    return isYourTurn & !this.gameOver;
  }

  function quadrantTaken(n){
    var pos = availableQuadrants.indexOf(n);
    availableQuadrants.splice(pos,1);
  }

  function isGameOver(gameRef){
    console.log(" Availabe quadrants : " + availableQuadrants);
    console.log(" Logging This in game",gameRef);
    if(!gameRef.gameOver){
      if (availableQuadrants.length == 0){
        console.log("Game Over");
        gameRef.gameOver = true;
      }else if(winner(gameRef)){
        gameRef.gameOver = true;
      }
    }
  }

  function winner(gameRef){

    var winner = false;
    var copy = null;
    if(isYourTurn){
      copy = yourQuadrants.slice();
    }else{
      copy = myQuadrants.slice();
    }
    if(copy.length <= 2){
      return false;
    }
    var q1 = copy.pop();
    var q2 = copy.pop();
    var q3 = copy.pop();

    if(q1.x == q2.x & q2.x == q3.x){
      winner = true;
    }else if(q1.y == q2.y & q2.y == q3.y){
      winner = true;
    }

    if(winner){
        gameRef.winner = true;
        console.log("winner ",gameRef)
        winningQuadrants.push(q1);
        winningQuadrants.push(q2);
        winningQuadrants.push(q3);
        return true;
    }
    return false;
  }
}




// Construct the app and initialize it
var app = new TicTacToe(300,300);
app.start();
