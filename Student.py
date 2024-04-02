mark = [90,86,73,52,38,63]
for i in mark:
    if(i>=90):
        print(f"{i} - O")
    elif(i>=80):
        print(f"{i} - A+")
    elif(i>=70):
        print(f"{i} - A")
    elif(i>=60):
        print(f"{i} - B+")
    elif(i>50):
        print(f"{i} - B")
    else:
        print(f"{i} - RA")
