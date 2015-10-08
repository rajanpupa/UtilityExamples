package threadMapReduce;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rajan P Upadhyay
 *
 * Sample data: cat sat fat
 */
public class ApplicationMapperReducer {
   
    static final String FOLDER_PATH = "D:/rajan/testfiles/";
    static final String FILE1 = "file1.txt";
    static final String FILE2 = "file2.txt";
    static final String FILE3 = "file3.txt";

    public static void withCombiner(){
        MapperCombiner mapper1 = new MapperCombiner(FOLDER_PATH + FILE1);
        MapperCombiner mapper2 = new MapperCombiner(FOLDER_PATH + FILE2);
        MapperCombiner mapper3 = new MapperCombiner(FOLDER_PATH + FILE3);
       
        Thread task1 = new Thread( mapper1);
        Thread task2 = new Thread( mapper2);
        Thread task3 = new Thread( mapper3);
       
        // start the mappers
        task1.start();
        task2.start();
        task3.start();
        
       
       
        try {
            //Thread.sleep(1000);
        	 task1.join();
             task2.join();
             task3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        System.out.println("-----printing mappers------");
        System.out.println(mapper1);
        System.out.println("-----------------------");
        System.out.println(mapper2);
        System.out.println("------------------------");
        System.out.println(mapper3);
        System.out.println("------------------------");
       
        //System.exit(0);
        Framework fmwk = new Framework();
       
        Reducer reducer1 = new Reducer();
        Reducer reducer2 = new Reducer();
        Reducer reducer3 = new Reducer();
       
        fmwk.addReducer(reducer1)
            .addReducer(reducer2)
            .addReducer(reducer3);
       
        fmwk.addTuples(mapper1.getResult());
        fmwk.addTuples(mapper2.getResult());
        fmwk.addTuples(mapper3.getResult());
       
        int transfers = fmwk.partition();
        System.out.println("Number of tuples moved with Combiner = " + transfers );
    }
    public static void withoutCombiner(){
        Mapper mapper1 = new Mapper(FOLDER_PATH + FILE1);
        Mapper mapper2 = new Mapper(FOLDER_PATH + FILE2);
        Mapper mapper3 = new Mapper(FOLDER_PATH + FILE3);
       
        Thread task1 = new Thread(mapper1);
        Thread task2 = new Thread(mapper2);
        Thread task3 = new Thread(mapper3);
       
        // start the mappers
        task1.start();
        task2.start();
        task3.start();
       
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        System.out.println("-----printing mappers------");
        System.out.println(mapper1);
        System.out.println("-----------------------");
        System.out.println(mapper2);
        System.out.println("------------------------");
        System.out.println(mapper3);
        System.out.println("------------------------");
       
        //System.exit(0);
        Framework fmwk = new Framework();
       
        Reducer reducer1 = new Reducer();
        Reducer reducer2 = new Reducer();
        Reducer reducer3 = new Reducer();
       
        fmwk.addReducer(reducer1)
            .addReducer(reducer2)
            .addReducer(reducer3);
       
        fmwk.addTuples(mapper1.getResult());
        fmwk.addTuples(mapper2.getResult());
        fmwk.addTuples(mapper3.getResult());
       
        int transfers = fmwk.partition();
        System.out.println("Number of tuples moved without combiner = " + transfers );
    }
   
    public static void main(String[] args) {
        //stringTest();
        withCombiner();
       
        withoutCombiner();
       
    }
   
    /**
     * Interface for Mapper
     */
    static interface IMapper{
        public void setFilePath(String filePath);
        public List<Map<String, Integer>> getResult();
       
        public String toString();
    }
   
    /**
     * Can run in parallel. <br/>
     * create an instance, set the filepath, and start it.
     *
     */
    static class Mapper implements Runnable, IMapper{

        String filePath = null;
        // final result producted by the mapper class
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
       
        public Mapper(){}
        public Mapper(String filePath){
            setFilePath(filePath);
        }
       
        @Override
        public void run() {
            loadFile();
        }
       
        private void loadFile(){
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
   
                String sCurrentLine;
   
                while ((sCurrentLine = br.readLine()) != null) {
                    //System.out.println(sCurrentLine);
                    for(String str: sCurrentLine.split("[ \n]")){
                        addToList(str);
                    }
                }
   
            } catch (IOException e) {
                e.printStackTrace();
            }
   
        }
        // puts a new map to the list
        private void addToList(String term){
            Map<String, Integer> hmap = new HashMap<String, Integer>();
            hmap.put(term, 1);
            mapList.add(hmap);
        }

        //getters and setters
        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
       
        public List<Map<String, Integer>> getResult(){
            return mapList;
        }
       
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(Map<String, Integer> m: mapList){
                for(String key : m.keySet()){//  runs 1 time only
                    sb.append(String.format("(%s, %d)\n", key, m.get(key) ));
                }
            }
            return sb.toString();
        }
    }
   
    /**
     * Can run in parallel. <br/>
     * create an instance, set the filepath, and start it.
     *
     */
    static class MapperCombiner implements Runnable, IMapper{

        String filePath = null;
        // final result producted by the mapper class
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
       
        public MapperCombiner(){}
        public MapperCombiner(String filePath){
            setFilePath(filePath);
        }
       
        @Override
        public void run() {
            loadFile();
        }
       
        private void loadFile(){
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
                String sCurrentLine;
   
                while ((sCurrentLine = br.readLine()) != null) {
                    //System.out.println(sCurrentLine);
                    for(String str: sCurrentLine.split("[ \n]")){
                       
                        addToList(str);
                    }
                }
   
            } catch (IOException e) {
                e.printStackTrace();
            }
   
        }
       
        // puts a new map to the list
        private void addToList(String term){
            Map<String, Integer> temp;
            Integer count;
            //System.out.println("Adding to list : " + term);
           
            for(Map<String, Integer> mp: mapList){
                count = mp.get(term);
               
                //System.out.println("count is :" + term+ ", " + count);
                if(count == null){
                    continue;
                }else{
                    mp.put(term, count+1);
                    //System.out.println("new count is :" + term+ ", " + count);
                    return;
                }
            }
           
            // if not in list, create a new map
            Map<String, Integer> hmap = new HashMap<String, Integer>();
            hmap.put(term, 1);
            mapList.add(hmap);
           
        }

        //getters and setters
        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
       
        public List<Map<String, Integer>> getResult(){
            return mapList;
        }
       
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(Map<String, Integer> m: mapList){
                for(String key : m.keySet()){//  runs 1 time only
                    sb.append(String.format("(%s, %d)\n", key, m.get(key) ));
                }
            }
            return sb.toString();
        }
       
    }

    static class Framework{
        List<Reducer> reducers = new ArrayList<Reducer>();
       
        List<List<Map<String, Integer>>> mapListList = new ArrayList<List<Map<String, Integer>>>();
       
        Partitioner p = new Partitioner();
       
        public Framework addReducer(Reducer r){
            reducers.add(r);
            return this;
        }
       
        public void addTuples(List<Map<String, Integer>> mapList){
            mapListList.add(mapList);
        }
       
        public int partition(){
            int count = 0;
            List<Map<String, Integer>> mapList;
           
            for (int index = 0; index < mapListList.size(); index++) {
                mapList = mapListList.get(index);

                for (Map<String, Integer> m : mapList) {
                    if (p.getPartition(m) == 0) {
                        reducers.get(0).addMap(m);
                        if (index == 0) {
                            count++;
                        }
                    } else if (p.getPartition(m) == 2) {
                        reducers.get(2).addMap(m);
                        if (index == 2) {
                            count++;
                        }
                    } else {
                        reducers.get(1).addMap(m);
                        if (index == 1) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }
   
    static class Partitioner {

        public int getPartition(Map<String, Integer> map) {

            for (String key : map.keySet()) {
                if (key.charAt(0) < 'k') {
                    return 0;
                } else if (key.charAt(0) > 'p') {
                    return 2;
                } else {
                    return 1;
                }
            }
            return 0;
        }

    }
   
    static class Reducer implements Runnable{
       
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
       
        @Override
        public void run() {
            // TODO Auto-generated method stub
           
        }
       
        public void addMap(Map<String, Integer> map){
            mapList.add(map);
        }
    }
}
