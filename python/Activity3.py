a = input("Enter the name of Player 1 : ")
b = input("Enter the name of Player 2 : ")

player1 = input(f"{a} choose 1 for Rock, 2 for Paper or 3 for Scissor : ")
player2 = input(f"{b} choose 1 for Rock, 2 for Paper or 3 for Scissor : ")

if player1 == player2:
    print("Its a Tie!")
elif player1 == "rock":
    if player2 == "scissor":
        print(f"{a} wins!!")
    elif player2 == "paper":
        print(f"{b} wins!!")
elif player1 == "scissor":
    if player2 == "paper":
        print(f"{a} wins!!")
    elif player2 == "rock":
        print(f"{b} wins!!")
elif player1 == "paper":
    if player2 == "rock":
        print(f"{a} wins!!")
    elif player2 == "scissor":
        print(f"{b} wins!!")
else:
    print("Invalid Input")