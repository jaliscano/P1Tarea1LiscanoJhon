#include <iostream>
#include <fstream>
using namespace std;
void liscanoGradesAndAverage();
void liscanoMenu();
void liscanoSaveToFile();
float liscanoGrades[3], liscanoAverage, liscanoTotal = 0;
int opMenu;
int main(){

    liscanoMenu();
    return 0;
}

void liscanoMenu(){
    cout<<"INGRESO DE NOTAS PARA CALCULAR EL PROMEDIO Y GUARDAR EN UN ARCHIVO"<<endl;
    do{
        cout<<"1. Ingreso de notas, y calculo del promedio"<<endl;
        cout<<"2. Guardar en un archivo .txt"<<endl;
        cout<<"3. Salir"<<endl;
        cin>>opMenu;
        switch(opMenu){
        case 1: liscanoGradesAndAverage();
            break;
        case 2:liscanoSaveToFile();
            break;
        case 3: cout<<"Saliendo del programa"<<endl;
            break;
        default:cout<<"Opcion erronea, intente de nuevo" << endl;
            break;
        }
    }while(opMenu!=3);
}

void liscanoGradesAndAverage(){
    cout<<"Ingrese tres notas"<<endl;
    for(int i=0; i<3; i++){
        cout<<"Ingrese la nota " <<i+1<< ":"<<endl;
        cin>>liscanoGrades[i];
        while(liscanoGrades[i]<0 || liscanoGrades[i]>20){
            cout<<"Error, las notas deben ser de 0 a 20, vuelva a ingresar"<<endl;
            cin>>liscanoGrades[i];
        }
        liscanoTotal = liscanoTotal + liscanoGrades[i];
    }
    liscanoAverage = liscanoTotal/3;
    cout<<"Promedio: "<<liscanoAverage<<endl;
    if(liscanoAverage>=14){
        cout<<"Fue Aprobado"<<endl;
    }else{
        cout<<"Fue Reprobado"<<endl;
    }
}

void liscanoSaveToFile(){
    ofstream file("liscanoNotas.txt");
    if(!file){
        cout<<"Error al abrir el archivo"<<endl;
        return;
    }
    file<<"Notas ingresadas:"<<endl;
    for(int i=0; i<3; i++){
        file<<"Nota "<<i+1<<": "<<liscanoGrades[i]<<endl;
    }
    file<<"Promedio: "<<liscanoAverage<<endl;

    if(liscanoAverage>=14){
        file<<"Estado: Aprobado"<<endl;
    }else{
        file<<"Estado: Reprobado"<<endl;
    }
    file.close();
    cout<<"Datos guardados en liscanoNotas.txt"<<endl;
}

