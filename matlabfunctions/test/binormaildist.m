function [ out ] = binormaildist()
out = 0.0;
for i=0;10, 
ncr = factorial(40)/(factorial(i)*factorial(40-i))
out = out + ncr*(0.1^i)*((1.0-0.1)^(40-i));    
end
