
<div align="center"><h2> 
Bitwise Operation 
</h2></div>

```Java
int x =   10; // bits are 0000 1010
int y =   6;  // bits are 0000 0110
int a = -11   // bits are 1111 0101
```

### NOT operator: ~
```Java
int ans = ~x; // bits are now 1111 0101
```

###  AND operator: &
```Java
int ans = x & y; // bits are now 0000 0010
```

###  OR operator: |
```Java
int ans = x | y; // bits are now 0000 1110
```

###  XOR operator: ^
```Java
int ans = x ^ y; // bits are now 0000 1100
```

### Right Shift operator: >>
Fills all of the bits on the left side with whatever the original leftmost bit was. The sign bit **does not change**.
```Java
int ans = a >> 2; // bits are now 1111 1101
int ans = x >> 1; // bits are now 0000 0101
```

### Unsigned Right Shift operator: >>>
Fills the leftmost bits with zeros. The sign bit **might change**.
```Java
int ans = a >>> 2; // bits are now 0011 1101
```

### Left Shift operator: <<
The rightmost bits are filled with zeros. The sign bit **might change**.
```Java
int ans = a << 2; // bits are 1101 0100
```


