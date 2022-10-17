package fr.univtln.bruno.i111.tp.tp3.animal.datastructures;

import fr.univtln.bruno.i111.tp.tp3.animal.Animal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAnimal implements Map<Animal.Tatouage, Animal> {
    private Map<Animal.Tatouage, Animal> animalMap;

    @Override
    public String toString() {
        return animalMap.toString();
    }

    public MapAnimal() {
        this.animalMap=new HashMap<>();
    }

    public MapAnimal(Map<Animal.Tatouage, Animal> animalMap) {
        this.animalMap=animalMap;
    }

    @Override
    public int size() {
        return animalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return animalMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return animalMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return animalMap.containsValue(value);
    }

    @Override
    public Animal get(Object key) {
        return animalMap.get(key);
    }

    @Override
    public Animal put(Animal.Tatouage key, Animal value) {
        return animalMap.put(key, value);
    }

    public Animal put(Animal animal) {
        return animalMap.put(animal.getTatouage(), animal);
    }

    @Override
    public Animal remove(Object key) {
        return animalMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Animal.Tatouage, ? extends Animal> m) {
        animalMap.putAll(m);
    }

    @Override
    public void clear() {
        animalMap.clear();
    }

    @Override
    public Set<Animal.Tatouage> keySet() {
        return animalMap.keySet();
    }

    @Override
    public Collection<Animal> values() {
        return animalMap.values();
    }

    @Override
    public Set<Entry<Animal.Tatouage, Animal>> entrySet() {
        return animalMap.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return animalMap.equals(o);
    }

    @Override
    public int hashCode() {
        return animalMap.hashCode();
    }

    @Override
    public Animal getOrDefault(Object key, Animal defaultValue) {
        return animalMap.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super Animal.Tatouage, ? super Animal> action) {
        animalMap.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super Animal.Tatouage, ? super Animal, ? extends Animal> function) {
        animalMap.replaceAll(function);
    }

    @Override
    public Animal putIfAbsent(Animal.Tatouage key, Animal value) {
        return animalMap.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return animalMap.remove(key, value);
    }

    @Override
    public boolean replace(Animal.Tatouage key, Animal oldValue, Animal newValue) {
        return animalMap.replace(key, oldValue, newValue);
    }

    @Override
    public Animal replace(Animal.Tatouage key, Animal value) {
        return animalMap.replace(key, value);
    }

    @Override
    public Animal computeIfAbsent(Animal.Tatouage key, Function<? super Animal.Tatouage, ? extends Animal> mappingFunction) {
        return animalMap.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Animal computeIfPresent(Animal.Tatouage key, BiFunction<? super Animal.Tatouage, ? super Animal, ? extends Animal> remappingFunction) {
        return animalMap.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Animal compute(Animal.Tatouage key, BiFunction<? super Animal.Tatouage, ? super Animal, ? extends Animal> remappingFunction) {
        return animalMap.compute(key, remappingFunction);
    }

    @Override
    public Animal merge(Animal.Tatouage key, Animal value, BiFunction<? super Animal, ? super Animal, ? extends Animal> remappingFunction) {
        return animalMap.merge(key, value, remappingFunction);
    }

    public static <K, V> Map<K, V> of() {
        return Map.of();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        return Map.of(k1, v1);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        return Map.of(k1, v1, k2, v2);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return Map.of(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(Entry<? extends K, ? extends V>... entries) {
        return Map.ofEntries(entries);
    }

    public static <K, V> Entry<K, V> entry(K k, V v) {
        return Map.entry(k, v);
    }

    public static <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return Map.copyOf(map);
    }

}
