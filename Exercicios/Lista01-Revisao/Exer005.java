/*
Data 09/08/2023

Descrição:
05 – Um estudante muito organizado está matriculado em N disciplinas, e dispões de um total semanal de H horas e
M minutos para estudar. Sua intenção é dividir o tempo disponível igualmente para as N disciplinas, e distribuir o
tempo de descanso que sobrar nas pausas entre as disciplinas. Crie um ou mais métodos para informar ao estudante
como ele deve organizar seu plano de estudos.
*/

import java.util.Scanner;

public class Exer005 {

    public static void imprimirCronograma(int disciplinas, int horas, int minutos) {
        int minutosPorDisciplina, horasPorDisciplina;
        minutos += horasParaMinutos(horas);

        minutosPorDisciplina = minutos / disciplinas;
        horasPorDisciplina = minutosPorDisciplina / 60;
        minutosPorDisciplina = minutosPorDisciplina % 60;

        System.out.println("Você deverá estudar " +  horasPorDisciplina + " horas e " + minutosPorDisciplina + " minutos por disciplina.");
    }

    private static int horasParaMinutos(int horas) {
        return horas * 60;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int disciplinas, horas, minutos;

        disciplinas = sc.nextInt();
        horas = sc.nextInt();
        minutos = sc.nextInt();

        imprimirCronograma(disciplinas, horas, minutos);

    }
}
