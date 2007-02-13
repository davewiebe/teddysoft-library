function [Y, nT] = SynthTrump( fs, dur )
%SYNTHTRUMP Summary of this function goes here
%   Detailed explanation goes here

nT = [0:dur/fs:dur-(1/fs)];
Y = 0;
a = [2100 80 950 180 770 300 350 660 250 260 260 110 90 50 70 53];
for n=1:1:length(a)
    Y = Y + ADSR(0.03, 0.01, 0.03, 0.8, (n*146.5), dur, 44100) .* 0.00006 .* (a(1,n).*cos((2*pi*n*146.5) .* nT));
end
Y = ADSR(0.2, 0.1, 0.2, 0.8, (n*146.5), dur, 44100) .* Y;

%ADSR(0.01, 0.001, 0.01, 0.8, (n*146.5), dur, 44100) .* || a(1,n)*

%y = y + 0.00005.*( (a(1,n) ).* (cos( (2*pi*n*146.5).* nT)) );