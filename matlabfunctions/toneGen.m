function [ y,nT ] = toneGen( f0, numHarm, fs, dur, type )
%f0: frequency, numHarm: Number of harmonics, fs: sampling rate
%dur: duration in seconds, type: type
%of tone (triangle, square, sawtooth,sine)
%Example: toneGen( 220, 20, 44100, 1, 'sine' ) creates a sinusoid that
% is 2 seconds long and has a sampling rate of 44100 with a frequency
% 22Hz
%

y = 0;
nT = [0:dur/fs:dur-1/fs];

if strcmp(type,'square') == 1
for n = 1:2:(numHarm*2)
    y = y +  (1/n) * sin( (2*pi*f0*n).*nT);
end
end

if strcmp(type,'triangle') == 1
for n = 1:2:(numHarm*2)
    y = y +  (1/(n^2)) * cos( (2*pi*f0*n).*nT);
end
end

if strcmp(type,'sawtooth') == 1
for n = 1:1:numHarm
    y = y +  (1/n) * sin( (2*pi*f0*n).*nT);
end
end

if strcmp(type,'sine') == 1
for n = 1:1:numHarm
    y = y +  sin(2*pi*f0.*nT);
end
end





