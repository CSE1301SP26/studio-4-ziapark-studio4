package studio4;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;
public class CookieClicker {
public static void main(String[] args){
    double[] chipX = new double[5];
    double[] chipY = new double[5];
    int score = 0;
    int clickPower = 1;
    int upgradeCost = 20;
    int idlePower = 1;
    int idleCost = 60;
 for (int i = 0; i < 5; i++){
        chipX[i] = Math.random()*0.1 - 0.05;
        chipY[i] = Math.random()*0.1 - 0.05;
        while (chipX[i] * chipX[i] + chipY[i] * chipY[i] > 0.05*0.05){
        chipX[i] = Math.random()*0.1 - 0.05;
        chipY[i] = Math.random()*0.1 - 0.05;}
}

long start = System.currentTimeMillis();
while (true){
    StdDraw.clear();

    StdDraw.setPenColor(181, 101, 29);
    StdDraw.filledCircle(0.5,0.5,0.05);

    StdDraw.setPenColor(255, 192, 203);
    StdDraw.filledRectangle(0.1, 0.8, 0.05, 0.05);
    StdDraw.setPenColor(0, 0, 0);
    StdDraw.setPenRadius(0.0001);
    StdDraw.text(0.105,0.805, "Upgrade Click");

    StdDraw.setPenColor(173, 216, 230);
    StdDraw.filledRectangle(0.1, 0.6, 0.05, 0.05);
    StdDraw.setPenColor(0, 0, 0);
    StdDraw.setPenRadius(0.0001);
    StdDraw.text(0.105,0.605, "Upgrade Idle");

    StdDraw.setPenColor(101, 67, 33);
    for (int i = 0; i < 5; i++){
         StdDraw.filledCircle(chipX[i] + 0.5, chipY[i] + 0.5,0.01);
    }

    double playerX = StdDraw.mouseX();
    double playerY = StdDraw.mouseY();

if (StdDraw.isMousePressed()){
   double innerValue = Math.pow(playerX - 0.5, 2) + Math.pow(playerY - 0.5, 2);
double distance = Math.sqrt(innerValue);
if (distance < 0.05){
    score+=clickPower;
}
}

if (StdDraw.isMousePressed()){
   double innerValue = Math.pow(playerX - 0.105, 2) + Math.pow(playerY - 0.805, 2);
double distance = Math.sqrt(innerValue);
if (distance < 0.05){
    score-=upgradeCost;
    clickPower = clickPower + 2;
    upgradeCost = upgradeCost + 2;
}
}

if (StdDraw.isMousePressed()){
   double innerValue = Math.pow(playerX - 0.105, 2) + Math.pow(playerY - 0.605, 2);
double distance = Math.sqrt(innerValue);
if (distance < 0.05){
    score-=idleCost;
    idlePower = idlePower + 1;
    idleCost = idleCost + 2;
}
}

while (StdDraw.isMousePressed()){
    StdDraw.pause(10);
}

StdDraw.text(0.5,0.1, "Score: " + score);
StdDraw.show(30);

long end = System.currentTimeMillis();
if (end - start > 1000){
    score+=idlePower;
    start = end;
}
}
}
}
