function [y,nT] = mycos(f0, dur, fs)
%f0: frequency in Hz
%dur: duration in seconds
%fs: sampling rate
%returns y: Vector of sampling points that form a sinusoid
%        T: Vector of time that has been made discreet in sync with
%           sampling rate fs.

w = 2*pi*f0;

nT = [0:dur/fs:dur];
nT(:,length(nT)) = [];
%nT = [0:dur/fs:3/200]; %Time vector to capture 3 cycles.

y = cos(w*nT);


