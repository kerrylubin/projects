# This is a sample Python script.
# This program calculates your Bsa

# Stappenplan
# 1. Maak een nieuw Python programma genaamd “BsaMonitor”.
# 2. Gebruik in je programma drie list’s, alle drie even lang:

# • Een list genaamd course_names waarin de namen van vakken en
#   projecten komen. Vul de lijst met de namen van de vakken en pro-jecten die jouw richting krijgt in semester 1.

# • Een list genaamd course_points waarin voor ieder vak
#   de studiepunten van de vakken en projecten staan. Vul deze array met de juiste studiepunten, dus:
#   course_names[1]="Programming"
#   course_points[1]=3 # doordat het vak Programming index 1 heeft weet je nu dat 3 bij Pro

# • Een list genaamd course_grades, waarin je de cijfers die je voor
#   elk vak behaalt zult opslaan.

# 3. Gebruik een loop om alle vakken af te gaan. Vraag de gebruiker per vak
#   om het behaalde of verwachte cijfer in te voeren en sla de ingevoerde cijfers
#   op in de list vakCijfers. done

# Zorg ervoor dat de gebruiker alleen geldige
# cijfers (tussen de 1.0 en de 10.0) kan invoeren door de invoer te controleren
# en opnieuw om het cijfer te vragen, als de invoer niet geldig is. TO DO

# 4. Nadat de gebruiker de cijfers heeft ingevoerd, kan het programma bepalen
#   hoeveel studiepunten je hebt gehaald voor ieder vak/project, gebaseerd
#   op het aantal studiepunten dat je kan verdienen en het cijfer dat je hebt
#   gehaald (of hoopt te halen). Je krijgt de bij het vak/project behorende
#   studiepunten als je cijfer groter of gelijk is aan 5,5. DONE

# 5. Gebruik weer een loop om alle vakken af te gaan:

#   5.1 Tel de daadwerkelijk behaalde studiepunten voor de vakken met een
#   voldoende cijfer op.

#   5.2 Tel de maximaal te behalen studiepunten voor alle vakken op.

#   5.3 Toon voor elk vak de resultaten op het scherm. Gebruik .format()
#   om deze netjes uit te lijnen. Zie https://www.w3schools.com/python/ref_string_format.asp voor voorbeelden.

# 6. Toon tenslotte het aantal behaalde studiepunten. Als het aantal behaalde
#   studiepunten kleiner is dan 5/6 van het totaal, dan moet de volgende
#   melding worden afgedrukt: “PAS OP: je ligt op schema voor een negatief
#   BSA!”.

# 7. Voldoet je programma aan de code conventions?


# Voorbeeld input en output Hieronder een voorbeeld van input/output van
# de applicatie voor de richting CS. Input die de gebruiker invoert is schuin en
# vetgedrukt.

# Totaal behaalde studiepunten: 23/28 PAS OP: je ligt op schema voor een negatief BSA!



def main():
    # Use a breakpoint in the code line below to debug your script.
    course_names = ['Project Fasten Your Seatbelts', 'Programming', 'Databases', 'Personal & Project Skills']
    course_points = [12, 3, 3, 4]
    course_grades = []

# ask for grades in for loop
    for course in course_names:
        # print(course)
        input_grades = float(input(f'What are your grades for {course}\n'))
        course_grades.append(input_grades)

        # print(f'Subject/Project: {course}: {course_grades}')


    for index, grades in enumerate(course_grades):
        # get course_name index
        if grades >= 5.5:
            course_points[index] = course_points[index]
        else:
            course_points[index] = 0

        if course_points[index] == 0:
            print(f'null')
        else:
            print(f'add points')
        #   5.1 Tel de daadwerkelijk behaalde studiepunten voor de vakken met een
        #   voldoende cijfer op.

        #   5.2 Tel de maximaal te behalen studiepunten voor alle vakken op.

        #   5.3 Toon voor elk vak de resultaten op het scherm. Gebruik .format()
        #   om deze netjes uit te lijnen. Zie https://www.w3schools.com/python/ref_string_format.asp voor voorbeelden.

        print(f'\nSubject/Project: {course_names[index]}: {grades}\n'
              f'Points obtained: {course_points[index]}\n')

    print(f'Total credits obtained: 23/28 WARNING: you are on track for a negative BSA!')

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
