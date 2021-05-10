import exceptions.*;

import java.util.Map;
import java.util.Set;

public interface IBank {

    /**
     * Dado un NIF, devuelve el id de cliente. Lanza una excepción si el cliente no existe.
     * @param nif
     * @return devuelve el id de cliente
     * @throws ClientNotFoundException
     */
    int getId (int nif) throws ClientNotFoundException;

    /**
     * Dado un NIF, devuelve las cuentas del cliente. Lanza una excepción si el cliente no existe
     * @param nif
     * @return devuelve las cuentas del cliente
     * @throws ClientNotFoundException
     */
   Set<Account> getClientAccounts (int nif) throws ClientNotFoundException;

    /**
     * Dado un IBAN y una cantidad, saca ese dinero de la cuenta.
     * @param iban
     * @param amount
     * @throws NotEnoughBalanceException
     * @throws AccountNotFoundException
     */
    void withdraw (String iban, double amount) throws NotEnoughBalanceException, AccountNotFoundException;

    /**
     * dada una cuenta de origen, una cuenta de destino y una cantidad, mueve la cantidad del origen al destino.
     * @param ibanOrigin
     * @param ibanDestination
     * @param amount
     * @throws ClientNotFoundException
     * @throws OriginAccountNotFOundException
     * @throws DestinationAccountNotFoundException
     */
    void  transfer (String ibanOrigin, String ibanDestination, double amount) throws  OriginAccountNotFOundException, DestinationAccountNotFoundException, NotEnoughBalanceException;

}
