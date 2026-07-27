$root = 'C:\Users\DELL\Desktop\coforge_training'
Set-Location $root
$repos = Get-ChildItem -Path . -Directory -Recurse -Force -ErrorAction SilentlyContinue | Where-Object { Test-Path (Join-Path $_.FullName '.git') } | Select-Object -ExpandProperty FullName
if (-not $repos) { Write-Output 'No git repos found.'; exit 0 }
foreach ($r in $repos) {
    Write-Output "==== Repo: $r"
    Set-Location $r
    $untracked = git ls-files --others --exclude-standard
    if ($untracked) {
        Write-Output 'Untracked files:'
        $untracked | ForEach-Object { Write-Output " - $_" }
        git add -- $untracked
        git commit -m 'Add untracked files' 2>&1 | Write-Output
        git push 2>&1 | Write-Output
    } else {
        Write-Output 'No untracked files in this repo'
    }
}
