// The for expression that computes Prime number
for{
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
}yield (i, j)

// Applying the translation scheme to this expression gives:
(i until n).flatMap(i =>
  (i until i).withFilter(j => isPrime(i+j))
  .map(j => (i, j)))

// Translate
for(b <- books; a <- b.authors if a startsWith "Bird")
  yield b.title







