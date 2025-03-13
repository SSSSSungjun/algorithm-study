#import sys
import sys

pic=[]
selected1=[]
selected2=[]
dx=[1,0,-1,0]
dy=[0,1,0,-1]
N=0

def color_weak(i,k):
    global pic,selected1,dx,dy
    selected1[i][k]=1
    stack=[]

    sel_color=pic[i][k]
    stack.append([i,k])

    while len(stack)!=0:
        tmp1,tmp2=stack[-1][0],stack[-1][1]
        stack.pop()

        for i in range(4):
            idx_x,idx_y=tmp1+dx[i],tmp2+dy[i]

            if idx_x<0 or idx_y<0 or idx_x>=N or idx_y>=N:
                continue
            if selected1[idx_x][idx_y]==1:
                continue
            if sel_color!='B' and pic[idx_x][idx_y]=='B':
                continue
            elif sel_color=='B' and pic[idx_x][idx_y]!='B':
                continue

            stack.append([idx_x,idx_y])
            selected1[idx_x][idx_y] = 1
    return 1

def color_clear(i,k):
    global pic, selected2, dx, dy
    selected2[i][k] = 1
    stack = []

    sel_color = pic[i][k]
    stack.append([i, k])

    while len(stack) != 0:
        tmp1, tmp2 = stack[-1][0], stack[-1][1]
        stack.pop()

        for i in range(4):
            idx_x, idx_y = tmp1 + dx[i], tmp2 + dy[i]

            if idx_x < 0 or idx_y < 0 or idx_x >= N or idx_y >= N:
                continue
            if selected2[idx_x][idx_y] == 1:
                continue
            if sel_color !=pic[idx_x][idx_y]:
                continue

            stack.append([idx_x, idx_y])
            selected2[idx_x][idx_y]=1

    return 1

def main():

    global pic,N,selected1,selected2
    N=int(sys.stdin.readline())
    pic=[[''for i in range(N)] for i in range(N)]
    selected1=[[0 for i in range(N)] for i in range(N)]
    selected2=[[0 for i in range(N)] for i in range(N)]
    cnt_weak,cnt_clear=0,0


    for i in range(N):
        pic[i]=list(sys.stdin.readline().rstrip())

    for i in range(N):
        for k in range(N):
            if selected1[i][k]==0:
                cnt_weak+=color_weak(i,k)
            if selected2[i][k]==0:
                cnt_clear+=color_clear(i,k)

    print(cnt_clear,cnt_weak)



main()