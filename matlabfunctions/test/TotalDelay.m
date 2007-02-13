function [ D ] = TotalDelay( LoverR )
%
a = 2.0*ones(1,length(LoverR));
D = a.*(LoverR.*LoverR).*((ones(1,length(LoverR)))-(a.*LoverR)) + LoverR;
