function [y, nT] = mycos2(f0, dur, fs, phi)
% MYCOS A cosine function.
%   [Y, NT] = MYCOS(F0, DUR, FS, PHI)
%
% - Y is a vector containing the cosine wave (with values between 0
%   and 1).
% - NT is the discrete time axis (nice to have for plotting)
% - FO is the fundamental frequency
% - DUR is the duration (in seconds)
% - FS is the sampling rate
% - PHI is optional, and is the initial phase
%
%   Example uses:
%   y = mycos(220, 1, 1024);
%
%   [y, nT] = mycos(220, 1, 2048, pi/2);
%   plot(nT, y);

if nargin == 3 phi = 0; end

nT = 0:1/fs:dur-1/fs;
y = cos(2*pi*f0.*nT + phi);