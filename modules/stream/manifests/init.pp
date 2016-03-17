class stream  {
   include apt

   exec { "apt-update":
       command => "/usr/bin/apt-get update"
   }

   Exec["apt-update"] -> Package <| |>

   Exec["apt-update"] -> Apt::Ppa <| |>

}
