class Solution {
    public int compress(char[] chars) {

       int read=0;
       int write=0;

       while(read<chars.length){
          char curr=chars[read];
          int count=0;

        while(read<chars.length && curr==chars[read]){
            count++;
            read++;
        } 

         chars[write] = curr;
          write++;

           if(count>1){
                String str = Integer.toString(count);

                for(int i=0;i<str.length();i++){
                    chars[write]=str.charAt(i);
                    write++;
                }
           }
       }
       return write;
    }
}
        // StringBuilder sb = new StringBuilder();
        // int i=0;
        // while(i<chars.length){
        //    char current=chars[i];
        //    int count=0;
        //    while(i<chars.length && chars[i]==current){
        //     count++;
        //     i++;
        //    }
        //     sb.append(current);
        //     if(count>1){
        //     sb.append(count);
        //    }
        // }

        // for(int j=0;j<sb.length();j++){
        //     chars[j]=sb.charAt(j);
        // }
        // return sb.length();