# AtCoder Beginner Contest 154 D - Dice in Line
# URL : https://atcoder.jp/contests/abc154/tasks/abc154_d
# time : 10min

n, k = map(int, input().split())
p = list(map(int, input().split()))
s = [0]
m = 0
for i in range(len(p)):
    p[i] = p[i] / 2 + 0.5
    s.append(s[i]+p[i])
for i in range(len(p)-k+1):
    m = max(m, s[i+k]-s[i])
print(m)