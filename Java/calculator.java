class calculator {
    
    int add (int x, int y){
        return x + y;
    }
    int sub (int x, int y) {
        return x - y;
    }
    int div (int x, int y) {
        return x/y;
    }
    int mult (int x, int y) {
        return x * y;
    }
}
void main () {
    calculator calc1 = new calculator ();
    calculator calc2 = new calculator ();
    calculator calc3 = new calculator ();
    calculator calc4 = new calculator ();

    int multi = calc3.mult (20,40);
    int divi = calc4.div (50,10);
    int subb = calc2.sub (20, 30);
    int addi = calc1.add (9, 10);
    IO.println("the sum is " + addi + "," + " the difference is " + subb + ","  + " the quotient is " + divi + ","  + " the product is " + multi);
}