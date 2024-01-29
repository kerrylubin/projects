# Kerry Lubin.
# This program generates random numbers.
# imports used: random. this generate random numbers with function random.randint(min, max)
# tricks used: print(*overview). By adding * to a list it prints everything at once.
# The while loop wil continue to execute a code only if a value remains true.

import random

def main():
    overview = []
    # aske for minimun guess number
    min_guess = int(input(f'Voer de minimum waarde in van het raad-getal: '))
    # ask for maximum guess number
    max_guess = int(input(f'Voer de maximum waarde in van het raad-getal: '))

    # generates random number from user input
    answer = random.randint(min_guess, max_guess)

    # chances is set to null
    chances = None

    # while variable chances null ask for input if int is higher than 5 show message.
    # if lower than 1 show message.
    while chances not in range(1, 6):

        chances = int(input(f'Hoe vaak mag er geraden worden [1-5]: '))

        if chances > 5:
            print(f'Je mag alleen een getal van 1 tot en met 5 invoeren. \n')
        elif chances < 1:
            print(f'Je mag alleen een getal van 1 tot en met 5 invoeren. \n')

    # variable guess is set to 0
    guess = 0
    # variables for message
    low = 'te laag.'
    high = 'te hoog.'

    # while variable guess is not the right answer, ask input.
    # if guess is right, show congratulation message, show overview, else, remove 1 chance,
    # if guess is greater than answer, show message to low else show message to high.
    # if chance is 0 show message, show overview quit program.
    while guess != answer:
        guess = int(input(f'Raad het raad-getal: '))

        if guess == answer:
            print(f'Gefeliciteerd!\nHieronder een overzicht van uw invoer: \n')
            print(*overview), print(f'{answer}, succes! ')
            # for view in overview:
            #     print(view)
            # print(f'{answer}, succes!')
        else:
            chances = chances - 1
            if guess > answer:
                print('Fout, te hoog! ')
                overview.append(str(guess) + ', ' + high)
            else:
                print('Fout, te laag! ')
                overview.append(str(guess) + ', ' + low)

            if chances == 0:
                print(f'Het raad getal was {answer}. Hieronder een overzicht van uw invoer: \n')
                print(*overview)
                # for view in overview:
                #     print(view)
                quit()

    # Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
