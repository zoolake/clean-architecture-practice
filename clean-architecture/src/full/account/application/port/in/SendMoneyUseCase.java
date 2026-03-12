package account.application.port.in;

public interface SendMoneyUseCase {
    void sendMoney(SendMoneyCommand command);
}
