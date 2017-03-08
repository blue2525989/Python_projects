# This is a program to visually plot sets of X & Y coordinates.
# Written by: Jason Bierbrauer, 1-20-2017
import os
import turtle

# Location of Random_XY on local computer. A program I made to supplement the need for XY text files.
rxy = "C:\\Users\\Jason\\Blue\\plot_data\\Random_XY.jar"


def prompt():
    """Main prompt when to display when program is run."""
    print("""\n\tWelcome to plot_data.py, this program is intended to allow you to
    visually plot data based off of X & Y coordinates from a text file.
    Please select a file or use Random_XY to create one.""")


def print_tree(dir_path):
    """Print full tree"""
    for name in os.listdir(dir_path):
        full_path = os.path.join(dir_path, name)
        print(full_path)
        if os.path.isdir(full_path):
            print_tree(full_path)


def draw_points():
    jason.pencolor("green")
    for line in lines:
        jason.penup()
        value = line.split()
        x = float(value[0])
        y = float(value[1])
        jason.goto(x, y)
        jason.stamp()


def plot_regression():
    bill.pencolor("blue")
    for line in lines:
        bill.penup()
        value = line.split()
        x = float(value[0])
        y = float(value[1])
        y2 = (mean_y + m) * (x - mean_x)
        bill.goto(x, y2)
        bill.stamp()


while True:
    prompt()

    # Get current working directory and display it.
    cwd = os.getcwd()
    print("\nCurrent working directory,")
    print(cwd)
    print_tree(cwd)

    # User input.
    choice = input("\nEnter Directory, Dir\\\Filename.ext, RandomXY, or exit: ")

    # Load selected file conditions.
    if str(choice).__contains__('.'):
        print("Here is your selected file,\n")
        # Attempts to open text file and parse line by line for two numbers.
        # Using turtle to plot data.
        jason = turtle.Turtle()
        jason.pencolor("blue")
        bill = turtle.Turtle()
        bill.pencolor("green")
        window = turtle.Screen()
        window.screensize(50000, 50000)
        try:
            f_obj = open(choice, 'r')
            lines = f_obj.readlines()
            n = len(lines)

            for line in lines:
                value = line.split()
                x = float(value[0])
                y = float(value[1])
                x += x
                y += y

            mean_x = x / n
            mean_y = y / n

            m1 = (x * y) - (n * mean_x * mean_y)
            m2 = (x ** 2) - (n * (mean_x ** 2))
            m = m1 / m2

            draw_points()
            plot_regression()

            window.exitonclick()
            exit()
        except FileNotFoundError:
            print("Sorry, " + choice + " is not valid.")
        except EnvironmentError:
            print("Sorry, error has happened.")
    # Load Random_XY.jar conditions.
    elif str(choice).__contains__('RandomXY'):
        try:
            os.system(rxy)
        except FileNotFoundError:
            print("Sorry, " + choice + " is not valid.")
    elif str(choice).__contains__('randomXY'):
        try:
            os.system(rxy)
        except FileNotFoundError:
            print("Sorry, " + choice + " is not valid.")
    elif str(choice).__contains__('Randomxy'):
        try:
            os.system(rxy)
        except FileNotFoundError:
            print("Sorry, " + choice + " is not valid.")
    elif str(choice).__contains__('randomxy'):
        try:
            os.system(rxy)
        except FileNotFoundError:
            print("Sorry, " + choice + " is not valid.")

    # Exit conditions.
    elif str(choice).__contains__('exit'):
        exit()
    elif str(choice).__contains__("Exit"):
        exit()
    elif str(choice).__contains__("EXIT"):
        exit()
    # Change Directory conditions.
    else:
        os.chdir(choice)
