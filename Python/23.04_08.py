S = raw_input()
N = input()
def rep(S, N):
    return S[:N], S[len(S)-N:-1]

print rep(S, N)
