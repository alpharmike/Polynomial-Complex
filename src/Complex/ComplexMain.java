package Complex;

public class ComplexMain {
    public static void main(String[] args) {
        CartesianComplex firstComplex = new CartesianComplex(1,1);
        CartesianComplex secondComplex = new CartesianComplex(3, 4);
        PolarComplex thirdComplex = new PolarComplex(1, 0.78);
        PolarComplex fourthComplex = new PolarComplex(2, 1.5);
        ComplexArithmetic complexArithmetic = new CartesianArithmetic(firstComplex, secondComplex);
        Complex addComp = new CartesianComplex(0, 0);
        addComp = complexArithmetic.add();
        ComplexArithmetic newComplexArithmetic = new PolarArithmetic(thirdComplex, fourthComplex);
//        Complex.Complex newComplex = complexArithmetic.divide();
        Complex newComplex = newComplexArithmetic.divide();
        CartesianComplex resComp = new CartesianComplex(67777777, 5);
//        System.out.println(resComp.convertToPolar().toString());
//        System.out.println(resComp.getCosine().toString());
//        System.out.println(Math.atan(-56));
        CartesianComplex cc = new CartesianComplex(0, 5);
        System.out.println(cc.getAngle());


    }
}
