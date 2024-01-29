#Kerry lubin
#BMI calculatior: Calculates your BMI with your height and weigth
# trick used: 18.5 <= bmi <= 25.0. this checks if bmi is in between these numbers.

import math


def main():
#ask user weigth
    weigth = input('What is your weight in kilos? \n')

#ask user height
    height = input('What is your height in cm? \n')

#change cm to meters
    height_meters = int(height) / 100

#calculate meters
    math_meter = pow(height_meters, 2)

#calculate bmi
    math_bmi = int(weigth) / math_meter

#round bmi	
    bmi = round(math_bmi, 2)

#display bmi
    print(f'BMI: {bmi}' )

# Checks if bmi is greater than 30 or under than 18.5

    if bmi > 30:
        print('You are Obese')
    elif 18.5 <= bmi <= 25.0:#this is how to check float is in range
        print('You have a healthy weight!')
    elif 25.0 <= bmi <= 30.0:
        print(f'You are overweight!')
    elif bmi <= 18.5:
        print('You are underweight!')

if __name__ == "__main__":
        main()
