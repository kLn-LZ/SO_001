package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

    public RedesController() {
        super();

    }

    private String os() {

        String os = System.getProperty("os.name");

        return os;


    }

    public void ip() throws IOException {


        String vOs = os();

        if (vOs.contains("Windows")) {

            try {
               Process p = Runtime.getRuntime().exec("IPCONFIG");
               InputStream fluxo = p.getInputStream();
               InputStreamReader leitor = new InputStreamReader(fluxo);

               BufferedReader buffer = new BufferedReader(leitor);
               String linha = buffer.readLine();

               while (linha != null) {

                   if(linha.contains("IPv4")) {

                       System.out.println(linha);
                   }

                   linha = buffer.readLine();

               }

               buffer.close();
               leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        else if(vOs.contains("Linux")) {

            try {
                Process p = Runtime.getRuntime().exec("ifconfig");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {

                    if(linha.contains("IPv4")) {

                        System.out.println(linha);
                    }

                    linha = buffer.readLine();

                }

                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public void ping () {
        String vOs = os();
        String avg[] = new String[3];



        if (vOs.contains("Windows")) {

            try {
                Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {

                    if(linha.contains("Average")) {

                        avg = linha.split(",");

                        System.out.println("Tempo médio do ping com o 'www.google.com.br");
                        System.out.println("============================================");
                        System.out.println(avg[2]);
                    }

                    linha = buffer.readLine();

                }

                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        else if(vOs.contains("Linux")) {

                try {
                    Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
                    InputStream fluxo = p.getInputStream();
                    InputStreamReader leitor = new InputStreamReader(fluxo);

                    BufferedReader buffer = new BufferedReader(leitor);
                    String linha = buffer.readLine();

                    while (linha != null) {

                        if(linha.contains("Average")) {

                            avg = linha.split(",");

                            System.out.println("Tempo médio do ping com o 'www.google.com.br");
                            System.out.println("============================================");
                            System.out.println(avg[2]);
                        }

                        linha = buffer.readLine();

                    }

                    buffer.close();
                    leitor.close();
                    fluxo.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


        }


    }

}
