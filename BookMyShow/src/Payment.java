public class Payment {
    int paymentId;
    int totalPrice;

    PaymentMode paymentMode;

    public Payment(int paymentId, int totalPrice, PaymentMode paymentMode){
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
        this.paymentMode = paymentMode;
    }

    public void completePayment(){
        System.out.println("Payment of "+totalPrice+" by "+paymentMode+" is successful");
    }
}
