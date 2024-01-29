# Kerry Lubin 500877727
# This programs chooses a candidate by votes
# functions used to count() this returns the counts of duplicates in a list
# The while loop wil continue to execute a code only if a value remains true.
# for index in range(number_of_voters): creates a loop depending on the list length.

def showCandidates(candidates):
    for value in candidates:
        print(f'De kandidaten:\n {candidates.index(value) + 1} - {value}\n')

def main():
    # candidate
    candidates = 0

    # votes list to store all votes
    votes = []
    # list for candidates names
    candidates_names = []

    # number of voters
    number_of_voters = 0

    # number of soesjes
    candies = 20

    # checks if minimal is 2 and maximum is 5
    while candidates == 0:
        candidates = int(input(f'Hoeveel kandidaten zijn er voor de verkiezing (2-5): '))

        if candidates > 5:
            print(f'Het minimale aantal is 2, het maximale aantal is 5.')
            candidates = 0
        elif candidates < 2:
            print(f'Het minimale aantal is 2, het maximale aantal is 5.')
            candidates = 0

    # add candidates names to list
    for index in range(candidates):
        quest_candidates = input(f'Wat is de naam van kandidaat {index + 1} : ')
        candidates_names.append(quest_candidates)


    # print(candidates_names)
    # checks if choosers is minimal 3 and maximal 15
    while number_of_voters == 0:
        number_of_voters = int(input(f'Hoeveel kiezers zijn er voor de verkiezing 3-15 : '))

        if number_of_voters > 15:
            print(f'Het minimale aantal is 3, het maximale aantal is 15.')
            number_of_voters = 0
        elif number_of_voters < 3:
            print(f'Het minimale aantal is 3, het maximale aantal is 15.')
            number_of_voters = 0

    # calculate gift
    gift_amount = round(candies / number_of_voters)

    # begin voting
    print(f'Het aantal soesjes per kiezer is: {gift_amount}\n')

    print(f'Het stemmen begint...\n')

    voter_cast = []
    # show candidates and choose who do you want to vote for
    for index in range(number_of_voters):
        showCandidates(candidates_names)

        while len(votes) != number_of_voters:

            voter_id = int(input(f'Wat is uw kiezersnummer? '))

            if voter_id in voter_cast:
                print(f'U heeft al gestemd!')
            else:
                voter_cast.append(voter_id)
                voters_choice = int(input(f'Op welke kandidaat wilt u stemmen? Geef het nummer in: '))
                votes.append(voters_choice)



    print(f'Alle kiezers hebben gestemd.')

    print(f'Resultaat (naam kandidaat, behaald aantal stemmen): \n')

    # calculate who is the winner
    for value in candidates_names:

        if votes.count(candidates_names.index(value) + 1) >= len(candidates_names):
            print(f'Kandidaat {candidates_names.index(value) + 1}, {value}, heeft gewonnen, gefeliciteerd!')

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
