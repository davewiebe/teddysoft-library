function [Xmag Xarg] = plotspec(x, fs, scale, zpf, window);
%  PLOTSPEC Plot the magnitue and phase response of the dft of x.
%	PLOTSPEC(X), plots using a normalized frequency axis: between
%	   0 and 0.5 (corresponding to the nyquist limit).
%       PLOTSPEC(X, FS), plots using a frequency axis in Hz.
%       PLOTSPEC(X, FS, 'SCALE'), specify 'lin' or 'log' magnitude.
%	PLOTSPEC(X, FS, 'SCALE', zpf), specify a zero pad factor (default
%          is 7).
%	PLOTSPEC(X, FS, 'SCALE', zpf, 'window'), specify a window, either
% 	   'rectangle' (default), 'bartlett', or 'hanning'.
%       [XMAG XARG] = PLOTSPEC(X), Xmag and Xarg are the the magnitude and 
%          phase of the frequency response of x, respectively.

if (nargin < 5) window = 'rectangle'; end
if (nargin < 4) zpf = 7; end
if (nargin < 3) scale = 'log'; end
if (nargin < 2) fs = 1; end;

if ~find(size(x)==1) disp('Error: x should be a vector'); end
if (find(size(x)==1) == 1) x = x'; end;         %change to a column vector
N = length(x);

switch window
  case 'hanning'
	x = x.*hanning(N);
  case 'bartlett'
	x = x.*bartlett(N);
  otherwise
	disp('using a rectangle window');
end
	
Nfft = 2^nextpow2(N*zpf);
X = fft(x, Nfft);
Xmag = abs(X);
Xarg  = angle(X);

if (scale == 'log')
  Xmag = 20*log10(Xmag);
  Xmag = max(Xmag-max(Xmag), -40); %don't plot anything lower than -40dB
end

faxis = [0:Nfft/2-1]*fs/Nfft;
subplot(211); plot(faxis, Xmag(1:Nfft/2));
set(gca, 'XLim', [0 max(faxis)]);
subplot(212); plot(faxis, Xarg(1:Nfft/2));
set(gca, 'XLim', [0 max(faxis)]);

