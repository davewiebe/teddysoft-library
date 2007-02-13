function [ Z ] = noisegen( dur, fs )
%
%

nT = [0:dur/fs:dur];
nT(:,length(nT)) = [];
L = length(nT);

Z = 0.5 * (randn(1, L ));
