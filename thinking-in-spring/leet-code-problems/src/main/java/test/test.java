package test;

public class test {
    public static void main(String[] args) {
        String recv="000892B86C37C1A09E49737E2F3139BCC35D78G0000601I87xA65/zsj5lLzJhAff3s5EJfAFjB1mPTUnAin85UF5G8DqqUGGAnZyEMjtT7XfZytT22fYxaZZ6T0FRnOgW3i5fXUTTh3wWrpVDqSh4GdeC4/omEUwobBTl9uJbURKMVa9c2h7eiU1GWJA58bFEnfG1+eNugug5x5CJCbL2jjX7Y9KZx+ThKfjkfGkzJhKMmmNITyR/ZSBnO4bB4uO02r1DyHtuezVBgCMQen4eGhbVUH7xKGFwAWKhJHlQgvlYzgEIfYAD/qRzJkySW5BjL6bBvUpY91m6iOHFO8VkYTFt/2qB0RV69JZhXY71f80gJJi+B99M/a0D7H9gq1GNgJT1MTn5kjOoSC4OJodeYriKfw1ub7KEtgcqyNCJJEwMB+XckFEPn5hFl6+l0Lz+HXXnY20JJa31aRSRQdYl1jJv+78zyMBm/wTbmlR3cKKdNqj4QbZgb6qWIGhm83e6JmNlDK+xfCywarSa5z82tX8sS9wZxKp3j9P8SR8Y3wkGZH+8mZFAGUmf22Nc+P3Cf81Nz7Od9N9gnt0VStiZfZLHn/sAOADAQ37tJ95E61FjFCrj5fN5uPGDTKxcGDjuH5Mvy/X+npudFzfrm0KVKZiP5w0PZmB8bf3Wyh574o9LwCdCq+0LgRXCZILpV/QchbgfpRWqNu5bskjaZWhUpPBjMcc60GIjx5Hl+JjlQj20ZsHu30IC8IO+fR9Dh5Yhr49EtKL/Y7UwwW36cwjQjXMv+g6dMPNasOOa/W8vSGciLLnUeS0Ai4aF8XM+6f0cmcfJDDHAOUFtjeflF2HDsgOawdqEQOZLK3AMYOwnAnE";
        String keyId = recv.substring(6,38);
        String encrypeRecv = recv.substring(46);
        String transcode = recv.substring(38,44);
        System.out.println(recv.substring(38,44));
//        System.out.println(str.substring(6,38));
//        System.out.println(str.substring(46));
    }
}
