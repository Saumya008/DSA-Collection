#array should be sorted

def binarySearch(a,x,si,ei):
    if si>ei:
        return -1
    
    mid =(si+ei)//2                         #finding middle element
    if a[mid]==x:                           #check if middle element is our required number
        return mid
    elif a[mid]>x:                          #else check if number is smaller or greater for which we are searching
        return binarySearch(a,x,si,mid-1)
    else:
        return binarySearch(a,x,mid+1,ei)

#main
#x is number you are searching for
x = int(input())
print(binarySearch([1,3,5,7,9,12,14,16,18,20],x,0,9))