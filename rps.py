import sys, random
print("Let's Play Rock, Paper, Scissors. The first to 5 points wins!!!")
w = 0
l = 0
t = 0
for j in range (1,6):
    print("%s wins, %s losses, %s ties " % (w,l,t) )
    for i in range (1,6):
        print("Enter r for rock, p for paper, s for scissors and q to quit ")
        user = input()
        if user == "q":
            sys.exit();
        elif user == "r" or user == "p" or user == "s":
            break
        else:
            print("Please enter p,r,s,or q")
            break
    rn= random.randint(1,3)
    if rn == 1:
        CM = "r"
        print("Computer Move : Rock")
    elif rn == 2:
        CM = "p"
        print("Computer Move : Paper")
    elif rn == 3:
        CM = "s"
        print("Computer Move : Scissors")

    if user == CM:
        print("It's a tie")
        t = t+1
    elif user == 'r' and CM == 's':
        print('You win!')
        w = w + 1
    elif user == 'p' and CM == 'r':
        print('You win!')
        w = w+ 1
    elif user == 's' and CM == 'p':
        print('You win!')
        w = w + 1
    elif user == 'r' and CM == 'p':
        print('You lose!')
        l = l + 1
    elif user == 'p' and CM == 's':
        print('You lose!')
        l = l + 1
    elif user == 's' and CM == 'r':
        print('You lose!')
        l = l + 1
if w > l:
    print("Congratulations!! You win")
else:
    print("Better luck next time!!")