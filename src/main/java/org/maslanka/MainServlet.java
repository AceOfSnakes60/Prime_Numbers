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
        System.out.println("main");
        if(!max.isEmpty()){
            System.out.println(max);
            req.setAttribute("primeRange", max);

            req.setAttribute("primeNumbers", calculatePrime(Integer.valueOf(max)));
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private String calculatePrime(int max){

        // Check every multiplication of i
        // for(y=i; i<sqrt(y); i++

        boolean isPrimeList[] = new boolean[max+1];
        Arrays.fill(isPrimeList, true);
        int start = 2;
        double end = sqrt(max);
        int count = 2;

        StringBuilder stringBuilder= new StringBuilder();

        for(int i = start; i<= end; i++){
            //check every multiplication of i
            if(isPrimeList[i]) {
                for (int y = i; y * i < max; y++) {
                    isPrimeList[i * y] = false;
                    count++;
                }
                //stringBuilder.append(i);
                //stringBuilder.append(", ");
                //Add prime number to list

            }
        }
        System.out.println(count);


        for(int i = 2; i< max; i++){
            if(isPrimeList[i]){
                stringBuilder.append(i);
                stringBuilder.append(", ");
            }
        }

        System.out.println("From string builder: " + stringBuilder);
        System.out.println(isPrimeList.length);
        System.out.println(end);
        return stringBuilder.toString();
    }
}
