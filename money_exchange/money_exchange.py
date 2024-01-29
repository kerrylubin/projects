# Kerry Lubin.
# This program exchanges foreign money to Euros.
# The while loop wil continue to execute a code only if a value remains true.

def main():
    currency = None
    percentage_fee = 1.5
    YEN = 0.0077
    USD = 0.85
    GBP = 1.17

#sets entered value to variable chosen_currency
    # chosen_currency = input(f'Choose a currency. \n 1 = USD, 2 = GBP, 3 = YEN.\n')

# checks entered value and sets currency rate to the variable
    while currency is None:
        chosen_currency = int(input(f'Choose a currency. \n 1 = USD, 2 = GBP, 3 = YEN.\n'))

        if chosen_currency == 1:
            chosen_currency = USD
            currency = 'USD'
        elif chosen_currency == 2:
            chosen_currency = GBP
            currency = 'GBP'
        elif chosen_currency == 3:
            chosen_currency = YEN
            currency = 'YEN'
        elif chosen_currency > 3:
            print(f'Choose the numbers displayed\n')

#sets entered value to variable amount
    amount = input(f'How much {currency} do you want to exchange?\n')

#calculates transaction currency rate
    transaction_amount = (float(amount) * chosen_currency)

#calculates transaction fee
    transaction_fee = (transaction_amount * percentage_fee / 100)

# calculates transaction amount
    transaction_amount = transaction_amount - transaction_fee

#checks if transaction amount and transaction fee is low or high
#then prints message and exit code
    if transaction_amount <= 0:
        print(f'The amount in {currency} you entered is to low!\n'
              f'Enter a higher amount.')
        exit()
    elif transaction_fee >= float(15):
        transaction_fee = 15
        print(f'The transaction fee is to high. The cost will now be {transaction_fee} Euros.\n')
        exit()
    elif transaction_fee <= 2:
        transaction_fee = 2
        print(f'The transaction fee is to low. The cost will now be {transaction_fee} Euros.\n')
        exit()

#prints your transaction information
    print(f'Your amount is: {float(amount) * chosen_currency} Euros.\n'
           f'The transaction fee is {round(transaction_fee, 2)} Euros.\n'
           f'You will receive {round(transaction_amount, 2)} Euros.')

    # Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
