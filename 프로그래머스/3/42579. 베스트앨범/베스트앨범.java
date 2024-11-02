import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + playCount);
            
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, playCount));
        }
        
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((s1, s2) -> s2.plays != s1.plays ? s2.plays - s1.plays : s1.id - s2.id);

            for (int i = 0; i < songs.size() && i < 2; i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Song {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
}