# Kerry Lubin
# This program is a plof game.
# The while loop wil continue to execute a code only if a value remains true.

import random


def main():
    # thud is none
    thud = None
    # while thud is not the inout show message
    while thud not in range(2, 10):

         thud = int(input(f'Wat is het plof getal (2..9)?'))

         if thud > 9:
             print(f'Je mag alleen een getal van 2 tot en met 9 invoeren.\n')
         elif thud < 2:
             print(f'Je mag alleen een getal van 2 tot en met 9 invoeren.\n')


    max_count = int(input(f'Tot en met welk getal moet ik tellen?'))

    count = 0
    # calculate plof
    plof = thud % max_count

    # create a count from max count
    # while count < max_count:
    #     count = count + 1

    for index in range(1, max_count+1):

        if index % thud == 0:
            print('plof')
        else:
            print(index)

if __name__ == '__main__':
    main()