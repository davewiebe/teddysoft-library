function [A] = ADSR(atime,dtime,rtime,sustainValue,f0,dur,fs)
%atime: Time in seconds for the attack
%dtime: Time in seconds for the decay
%rtime: Time in seconds for the release
%sustainValue: Amplitude for the sustain portion of the sinusoid.
%              ex: 1.0 = 100 percent and 0.8 = 80 percent.
%f0: frequency in Hz
%dur: Time of the sinusoid in seconds
%fs: sampling rate 
%Returns a vector that can be dot multiplied with the vector of
%  sinusoid samples to form an ADSR envelope upon the sinusoid vector.
NumOfAttackSamples = fs*atime;
NumOfDecaySamples = fs*dtime;
NumOfReleaseSamples = fs*rtime;
T = [0:dur/fs:dur-1/fs];
AttackPartition = [0:1/NumOfAttackSamples:1];
DecayPartition = [1:-0.2/NumOfDecaySamples:sustainValue];
ReleasePartition = [sustainValue:(-1*sustainValue)/NumOfReleaseSamples:0];

A = [ AttackPartition DecayPartition  [sustainValue.*ones( 1,(length(T)-length(AttackPartition) - length(DecayPartition) - length(ReleasePartition)) )] ReleasePartition  ];
%A is a concatenation of the various partitions enveloped around a
%  generated vector of sustainValue values where sustainValue is an
%  input constant