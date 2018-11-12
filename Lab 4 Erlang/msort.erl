% Homework: Basics on Erlang
% 
% 
% 
% Name: Wilmer
% Surname: Uruchi
% 
% Name: Carlos
% Surname: Rojas Morales
% 
% 
%
% Mergesort
%
-module(msort).
-compile(export_all).

sep(L,0) -> {[],L};
sep([H|T], N) -> {Lleft, Lright} = sep(T, N-1), {[H | Lleft], Lright}.

% merge(L1,L2) -> lists:sort(L1 ++ L2).

% merge(L1,L2) 				-> merge(reverse(L1),reverse(L2),[]).
% merge([H1|T1],[H2|T2],L3) 	when H1 > H2 -> merge(T1,[H2|T2],[H1|L3]);
% merge([H1|T1],[H2|T2],L3) 	-> merge([H1|T1], T2, [H2|L3]);
% merge([],[H2|T2],L3) 		-> merge([], T2, [H2|L3]);
% merge([H1|T1],[],L3) 		-> merge(T1,[],[H1|L3]);
% merge([],[],L3)				-> L3.

% reverse(L) 			->  reverse(L,[]).
% reverse([H|T],L)	-> 	reverse(T,[H|L]);
% reverse([],L) 		->	L.


merge([H1|T1],[H2|T2]) 	when H1 =< H2 -> [H1|merge(T1,[H2|T2])];
merge([H1|T1],[H2|T2])	-> [H2|merge([H1|T1],T2)];
merge([],[H2|T2]) 	 	-> [H2|merge([],T2)];
merge([H1|T1],[]) 	 	-> [H1|merge(T1,[])];
merge([],[])			-> [].


ms([]) -> [];
ms([A]) -> [A];
ms(L) -> {L1,L2} = sep(L, length(L) div 2), LL = ms(L1), LR = ms(L2), merge(LL,LR).


rcvp(Pid) -> 
	receive
		{Pid, L} -> L
	end.

pms(L) -> 
	Pid = spawn(msort, p_ms, [self(), L]),
	rcvp(Pid).

p_ms(Pid, L) 
	when length(L) < 100 -> Pid ! {self(), ms(L)};

p_ms(Pid, L) -> {Lleft, Lright} = sep(L, length(L) div 2),
	% Pid1 = spawn(msort, p_ms, [self(), Lleft]),
	% Pid2 = spawn(msort, p_ms, [self(), Lright]),
	Pid1 = pms(Lleft),
	Pid2 = pms(Lright),
	L1 = rcvp(Pid1),
	L2 = rcvp(Pid2),
	Pid ! {self(), merge(L1, L2)}.