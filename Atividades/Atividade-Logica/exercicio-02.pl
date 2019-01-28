%facts
eh(deus, amor).
eh(amor, cego).
eh(steve_wonder, cego).

%Rules
logo_eh(X, Y) :-
    eh(X, Y).
logo_eh(X, Y) :-
    eh(X, Z),
    logo_eh(Z, Y).

%facts
dieta(verdura).
dieta(peixe).
elefante_come(verdura).
elefante_eh(gordo).
baleia_come(peixe).
baleia_eh(gordo).

%Rules
dieta_faz(X, Y) :-
    (   dieta(X), elefante_come(X), elefante_eh(Y));
    (   dieta(X), baleia_come(X), baleia_eh(Y)).

%Facts
mais_queijo(mais_queijo).
menos_queijo(menos_queijo).
mais_buracos(mais_buracos).

%Rules
quanto_mais(queijo, Y):-
    quanto_mais(buracos, Y).
quanto_mais(buracos, Y):-
    menos_queijo(Y).

%Queries
% a) logo_eh(steve_wonder, deus). A resposta é falso,
% pois a lógica usada é que, se X é Y e Y é Z, logo X também é Z.
% steve_wonder é cego, mas cego não é nada a mais.
% 
% b) dieta_faz(COME,PESO). O resultado é gordo com base no individuos da base.
% 
% c) quanto_mais(queijo, menos_queijo). O resultado é verdadeiro,
% pois, a afirmação de mais queijo, leva a afirma que há mais buracos,
%  e quando há mais buracos, há menos queijo.