package org.maslanka;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String max = req.getParameter("max");
        int maxNum;
        try{
            maxNum = Integer.parseInt(max);
        } catch (NumberFormatException e){
            req.setAttribute("message", "Not a number.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }



        if(max.isEmpty()){
            req.setAttribute("message", "Please add a max number.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        System.out.println("calculating");
        req.setAttribute("primeRange", max);
        req.setAttribute("primeNumbers", calculatePrime(Integer.parseInt(max)));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private String calculatePrime(int max){

        boolean isPrimeList[] = new boolean[max+1];
        Arrays.fill(isPrimeList, true);
        int start = 2;
        double end = sqrt(max);

        StringBuilder stringBuilder= new StringBuilder();

        for(int i = start; i<= end; i++){
            //check every multiplication of i
            if(isPrimeList[i]) {
                for (int y = i; y * i < max+1; y++) {
                    isPrimeList[i * y] = false;
                }
            }
        }
        //write down prime numbers to string builder
        for(int i = 2; i< max+1; i++){
            if(isPrimeList[i]){
                stringBuilder.append(i);
                stringBuilder.append(", ");
            }
        }
        //Remove last coma
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());

        return stringBuilder.toString();
    }
}
