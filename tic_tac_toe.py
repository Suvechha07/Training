import math


def print_board(board):
    for row in board:
        print(" ".join(row))
    print()


def is_winner(board, player):
    for row in board:
        if all(s == player for s in row):
            return True
    for col in range(3):
        if all(board[row][col] == player for row in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)) or all(board[i][2 - i] == player for i in range(3)):
        return True
    return False


def is_full(board):
    return all(cell != ' ' for row in board for cell in row)


def evaluate(board):
    if is_winner(board, 'X'):
        return 10
    elif is_winner(board, 'O'):
        return -10
    return 0


def minimax(board, depth, is_maximizing):
    score = evaluate(board)

    if score == 10 or score == -10 or depth == 2 or is_full(board):
        return score

    if is_maximizing:
        best = -math.inf
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'X'
                    best = max(best, minimax(board, depth + 1, False))
                    board[i][j] = ' '
        return best
    else:
        best = math.inf
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'O'
                    best = min(best, minimax(board, depth + 1, True))
                    board[i][j] = ' '
        return best


def find_best_move(board):
    best_val = -math.inf
    best_move = (-1, -1)

    for i in range(3):
        for j in range(3):
            if board[i][j] == ' ':
                board[i][j] = 'X'
                move_val = minimax(board, 0, False)
                board[i][j] = ' '

                if move_val > best_val:
                    best_move = (i, j)
                    best_val = move_val

    return best_move, best_val


# Initialize the game board
board = [[' ' for _ in range(3)] for _ in range(3)]

# Find and print the best move and utility score for the root node
best_move, utility_score = find_best_move(board)
print("Best move:", best_move)
print("Utility score for root node:", utility_score)
